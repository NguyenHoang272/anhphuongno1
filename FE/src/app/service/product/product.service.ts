import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable } from "rxjs";
import { ProductHomeShow } from "src/app/dto/product-home-show";
import { Category } from "src/app/model/product/category";
import { Product } from "src/app/model/product/product";
import { ProductSearchInfo } from "src/app/payload/request/product-search-info";
import { ProductDetailInfoResponse } from "src/app/payload/response/product-detail-info-response";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: "root",
})
export class ProductService {

  /* Search info */
  productSearchNameInfo: string = '';
  productBrandInfo: string = '-1';
  productCategoryInfo: string = '-1';
  productPriceInfo: string = '0-999999999999999999999';
  pageNumber: string = '0';
  sortByPrice: string = '';

  constructor(private httpClient: HttpClient) {
  }

  updateProductSearchName(productSearchName: string) {
    this.productSearchNameInfo = productSearchName;
  }

  searchProduct(productSearchInfomartion: ProductSearchInfo): Observable<any> {
    const searchInfo: ProductSearchInfo = {
      productName: this.productSearchNameInfo,
      categoryId: this.productCategoryInfo,
      brandId: this.productBrandInfo,
      priceRange: productSearchInfomartion.priceRange,
      pageSize: '9',
      pageNumber: this.pageNumber,
      sortByPrice: this.sortByPrice
    }
    return this.httpClient.post<any>(environment.API_URL + "api/v1/product/searchProduct", searchInfo);
  }

  getProductById(productId: string): Observable<ProductDetailInfoResponse> {
    return this.httpClient.get<ProductDetailInfoResponse>(environment.API_URL + "api/v1/product/getProductById/" + productId)
  }

  getProductCategory(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(environment.API_URL + "api/v1/category/getAllCategroy");
  }

}
