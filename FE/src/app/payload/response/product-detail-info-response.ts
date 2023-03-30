import { Product } from "src/app/model/product/product";
import { ProductDetailInfo } from "./product-detail-info";

export interface ProductDetailInfoResponse {
    product?: Product;
    productOrderDetailDtoList?: ProductDetailInfo[];
}
