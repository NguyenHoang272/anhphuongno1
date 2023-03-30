import { Component, OnInit } from '@angular/core';
import { ProductOrderDetail } from 'src/app/model/order/product-order-detail';
import { UserInformation } from 'src/app/payload/response/user-information';
import { OrderService } from 'src/app/service/order/order.service';
import { TokenServiceService } from 'src/app/service/security/token-service.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  /* User information */
  userInformation: UserInformation;
  userId: string;

  /* Pagination information */
  totalPages: number = 0;
  currentPage: number = 0;

  /* Product order */
  productOrderList: any;
  productOrderDetailList: ProductOrderDetail[];


  constructor(
    private orderService: OrderService,
    private tokenService: TokenServiceService
  ) { }

  ngOnInit(): void {
    this.userInformation = JSON.parse(this.tokenService.getUserInformation());
    this.userId = String(this.userInformation.userId);
    this.getProductOrderHistory();
  }

  /* Product order methods */
  getProductOrderHistory() {
    this.orderService.getProductOrderHistory(this.userId).subscribe((data) => {
      this.totalPages = data.totalPages;
      this.currentPage = data.pageable.pageNumber;
      this.productOrderList = data.content;
    });
  }

  /* Pagination methods */
  toPage(page: string) {
    this.orderService.pageNumber = page;
    this.getProductOrderHistory();
  }

  previousPage() {
    this.orderService.pageNumber = JSON.stringify(
      +this.orderService.pageNumber - 1
    );
    this.getProductOrderHistory();
  }

  nextPage() {
    this.orderService.pageNumber = JSON.stringify(
      +this.orderService.pageNumber + 1
    );
    this.getProductOrderHistory();
  }

}
