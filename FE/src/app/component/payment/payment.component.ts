import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ProductOrder } from "src/app/model/order/product-order";
import { ProductOrderDetail } from "src/app/model/order/product-order-detail";
import { Address } from "src/app/model/user/address";
import { User } from "src/app/model/user/user";
import { OrderService } from "src/app/service/order/order.service";

@Component({
  selector: "app-payment",
  templateUrl: "./payment.component.html",
  styleUrls: ["./payment.component.css"],
})
export class PaymentComponent implements OnInit {

  /* Product order information */
  productOrderDetailList: ProductOrderDetail[] = [];
  productOrder: ProductOrder;
  estimatedMoney: number = 0;
  
  /* User information */
  userId: string;
  userAddress: Address;
  fullAddress: string;
  currentUser: User;
  fullName: string;
  phoneNumber: string;
  totalMoney: number;

  constructor(
    private orderService: OrderService,
    private activatedRoute: ActivatedRoute
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
      this.currentUser = data.user;
      this.productOrderDetailList = data.productOrderDetailSet;
      this.totalMoney = data.totalMoney;
      this.orderService.convertVNDToUSD(this.totalMoney);


      for (let i = 0; i < this.productOrderDetailList.length; i++) {
        this.estimatedMoney = this.estimatedMoney + 
        (this.productOrderDetailList[i].quantity * this.productOrderDetailList[i].product.price) 
      }

      this.getUserInformation();
    });
  }

  /* Get user information */
  getUserInformation() {
    this.userAddress = this.currentUser.addressSet[0];

    this.fullAddress = this.userAddress.addressDetail + ', phường ' + this.userAddress.town + ', quận ' + this.userAddress.district
    + ', thành phố ' + this.userAddress.city;

    this.fullName = this.currentUser.firstName + ' ' + this.currentUser.lastName;

    this.phoneNumber = this.currentUser.phone;
  }

  

}
