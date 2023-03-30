import { Product } from "../product/product";
import { ProductOrder } from "./product-order";

export interface ProductOrderDetail {
    id?: number;
    quantity?: number;
    deleteStatus?: number;
    product?: Product;
    productOrder?: ProductOrder;
}
