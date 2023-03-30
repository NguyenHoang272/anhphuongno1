import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { ProductHomeShow } from "src/app/dto/product-home-show";
import { ProductOrder } from "src/app/model/order/product-order";
import { ProductOrderDetail } from "src/app/model/order/product-order-detail";
import { UserInformation } from "src/app/payload/response/user-information";
import { OrderService } from "src/app/service/order/order.service";
import { ProductService } from "src/app/service/product/product.service";
import { AuthServiceService } from "src/app/service/security/auth-service.service";
import { TokenServiceService } from "src/app/service/security/token-service.service";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.css"],
})
export class HeaderComponent implements OnInit {

  /* Authen information */
  checkLogin = false;
  rfLogin: FormGroup;

  /* Search Information */
  productSearchName: string = '';

  /* User information */
  userInformation: UserInformation;
  userId: string;
  currentCartQuantity: number = 0;

  /* Product order information */
  productOrderDetailList: ProductOrderDetail[] = [];
  productOrder: ProductOrder;

  constructor(
    private formBuiler: FormBuilder,
    private authService: AuthServiceService,
    private tokenService: TokenServiceService,
    private productService: ProductService,
    private router: Router,
    private orderService: OrderService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    if (this.tokenService.isLogged()) {
      this.checkLogin = true;

      this.userInformation = JSON.parse(this.tokenService.getUserInformation());
      this.userId = String(this.userInformation.userId);
      
      this.getProductOrder();
    }
    this.getLoginForm();
  }

  /* Authen methods */
  getLoginForm() {
    this.rfLogin = this.formBuiler.group({
      username: [""],
      password: [""],
    });
  }

  login() {
    this.authService.login(this.rfLogin.value).subscribe((data) => {
      if (data.token !== undefined) {
        this.tokenService.setTokenSession(data.token);
        this.tokenService.setRoleSession(data.roles);
        this.tokenService.setUserInformationSession(data.userInfomartion);

        this.router.navigate([""]).then(() => {
          location.reload();
        });
      }
    });
  }

  logOut() {
    this.tokenService.logOut();
    this.router.navigateByUrl("").then(() => {
      location.reload();
    });
  }

  /* Search methods */
  searchProduct() {
    this.productService.updateProductSearchName(this.productSearchName);
    document.getElementById("search-multiple").click();
  }

  /* Product order methods */
  getProductOrder() {
    this.orderService.getProductOrder(this.userId).subscribe((data) => {
      this.orderService.productOrderId = data.id;
      this.productOrderDetailList = data.productOrderDetailSet;
      this.currentCartQuantity = 0;

      for (let i = 0; i < this.productOrderDetailList.length; i++) {
        this.currentCartQuantity = this.currentCartQuantity + this.productOrderDetailList[i].quantity;
      }

    });
  }

  /* Toggle authen modal */

  openAuthenModal(choice: string) {

    this.closeAuthenModal();

    document.getElementById("authenModal").style.display = "flex";

    if(choice === 'login') {
      document.getElementById("loginModal").style.display = "block";
    } else {
      document.getElementById("registerModal").style.display = "block";
    }
  }

  closeAuthenModal() {
    document.getElementById("loginModal").style.display = "none";
    document.getElementById("registerModal").style.display = "none";
    document.getElementById("authenModal").style.display = "none";
  }

  /* Cart methods */
  removeFromCart(productOrderDetailId: string) {
    this.orderService.removeFormCart(productOrderDetailId).subscribe(data => {
      this.toastr.success('Xóa khỏi giỏ hàng thành công')
      this.getProductOrder();
      document.getElementById('reloadCartId').click();
    })
  }

}
