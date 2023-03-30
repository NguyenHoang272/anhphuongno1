import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ToastrModule, ToastrService } from "ngx-toastr";
import { Product } from "src/app/model/product/product";
import { ProductDetailInfo } from "src/app/payload/response/product-detail-info";
import { ProductDetailInfoResponse } from "src/app/payload/response/product-detail-info-response";
import { OrderService } from "src/app/service/order/order.service";
import { ProductService } from "src/app/service/product/product.service";
import { TokenServiceService } from "src/app/service/security/token-service.service";

@Component({
  selector: "app-product-detail",
  templateUrl: "./product-detail.component.html",
  styleUrls: ["./product-detail.component.css"],
})
export class ProductDetailComponent implements OnInit {

  /* Product information */
  productId: string;
  currentProduct: Product = {
    name: "",
  };
  productListImgShown: string[] = new Array();
  productDetailInfoList: ProductDetailInfo[];
  mainPictureUrl: string;

  /* Add to cart information */
  productQuantity: number = 1;

  constructor(
    private activatedRoute: ActivatedRoute,
    private productService: ProductService,
    private orderService: OrderService,
    private toastr: ToastrService,
    private tokenService: TokenServiceService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      this.productId = params.productId;
      this.getProductById();
    });
  }

  /* Show product detail methods */
  getProductById() {
    this.productService.getProductById(this.productId).subscribe((data) => {
      this.currentProduct = data.product;
      this.productDetailInfoList = data.productOrderDetailDtoList;

      this.getProductListImgShown();
      this.mainPictureUrl = this.currentProduct.imgUrlProductList[0].url;
    });
  }

  getProductListImgShown() {
    if (this.currentProduct.imgUrlProductList.length < 5) {
      for (let i = 0; i < this.currentProduct.imgUrlProductList.length; i++) {
        this.productListImgShown.push(
          this.currentProduct.imgUrlProductList[i].url
        );
      }
    } else {
      for (let i = 0; i < 5; i++) {
        this.productListImgShown.push(
          this.currentProduct.imgUrlProductList[i].url
        );
      }
    }
  }

  /* Picture methods */
  changeMainPicture(pictureIndex: number) {
    this.mainPictureUrl = this.productListImgShown[pictureIndex];
  }

  /* Add to cart method */
  addProductQuantity() {
    this.productQuantity = this.productQuantity + 1;
  }

  removeProductQuantity() {
    this.productQuantity = this.productQuantity - 1;
  }

  addProductToCart(productId: number) {
    if (!this.tokenService.isLogged()) {
      this.toastr.info('Vui lòng đăng nhập')
    } else {
      this.orderService.addProductToCart(this.productQuantity, productId).subscribe(data => {
        this.toastr.success("Thêm thành công!")
          document.getElementById("reloadHeaderViewCart").click();
      })
    }

  }
}
