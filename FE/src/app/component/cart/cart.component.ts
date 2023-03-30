import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { ProductOrder } from "src/app/model/order/product-order";
import { ProductOrderDetail } from "src/app/model/order/product-order-detail";
import { TotalMoney } from "src/app/payload/request/total-money";
import { OrderService } from "src/app/service/order/order.service";

@Component({
  selector: "app-cart",
  templateUrl: "./cart.component.html",
  styleUrls: ["./cart.component.css"],
})
export class CartComponent implements OnInit {

  /* Product order information */
  productOrderDetailList: ProductOrderDetail[] = [];
  productOrder: ProductOrder;
  estimatedMoney: number = 0;

  /* User information */
  userId: string;

  constructor(
    private orderService: OrderService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      this.userId = params.userId;
    });

    this.getProductOrder();
  }

  /* Product order methods */
  getProductOrder() {
    this.orderService.getProductOrder(this.userId).subscribe((data) => {
      this.productOrder = data;
      this.productOrderDetailList = data.productOrderDetailSet;
      this.orderService.productOrderId = data.id;

      for (let i = 0; i < this.productOrderDetailList.length; i++) {
        this.estimatedMoney = this.estimatedMoney + 
        (this.productOrderDetailList[i].quantity * this.productOrderDetailList[i].product.price) 
      }

    });
  }

  removeFormCart(producerOrderDetailId: string) {
    this.orderService.removeFormCart(producerOrderDetailId).subscribe(data => {
      this.toastr.success('Xóa khỏi giỏ hàng thành công')
      this.getProductOrder();
      document.getElementById("reloadHeaderViewCart").click();
    })
  }

  /* Calculate methods */
  calculateMoney(producerOrderDetailId: string, operator: string) {
    var quantity = +document.getElementById('productOrderDetailQuantity' + producerOrderDetailId).innerHTML;
    var price = +document.getElementById('productOrderDetailPrice' + producerOrderDetailId).dataset.price;
    var currentTotalMoney = +document.getElementById('productOrderDetailTotalMoney' + producerOrderDetailId).innerHTML;
    var afterTotalMoney = 0;

    /* Changing the quantity */
    if (operator === '1') {
      quantity = +quantity + 1;
    } else {
      quantity = +quantity - 1;
    }
    document.getElementById('productOrderDetailQuantity' + producerOrderDetailId).innerHTML = JSON.stringify(quantity);

    /* Changing the total money of each product */
    afterTotalMoney = quantity * price;
    document.getElementById('productOrderDetailTotalMoney' + producerOrderDetailId).innerHTML = JSON.stringify(afterTotalMoney);

    /* Changing the estimated money */
    this.estimatedMoney = this.estimatedMoney - currentTotalMoney + afterTotalMoney;
  }

  /* Payment methods */
  payment(userId: string) {
    const totalMoney: TotalMoney = {
      totalMoney: JSON.stringify(this.estimatedMoney),
      orderId: JSON.stringify(this.productOrder.id)
    }

    this.orderService.updateTotalMoney(totalMoney).subscribe(() => {
      this.router.navigate(['/payment',userId]);
    });    
  }
   
}
