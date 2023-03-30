import { Component, OnInit } from "@angular/core";
import { ProductOrder } from "src/app/model/order/product-order";
import { ProductOrderDetail } from "src/app/model/order/product-order-detail";
import { OrderService } from "src/app/service/order/order.service";
import { TokenServiceService } from "src/app/service/security/token-service.service";
import { UserInformation } from "../../payload/response/user-information";

@Component({
  selector: "app-user-information",
  templateUrl: "./user-information.component.html",
  styleUrls: ["./user-information.component.css"],
})
export class UserInformationComponent implements OnInit {

  /* User information */
  userInformation: UserInformation;
  userId: string;

  constructor(
    private tokenService: TokenServiceService
  ) {}

  ngOnInit(): void {
    this.userInformation = JSON.parse(this.tokenService.getUserInformation());
    this.userId = String(this.userInformation.userId);
  }

}
