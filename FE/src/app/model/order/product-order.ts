import { ProductOrderDetail } from "./product-order-detail";

export interface ProductOrder {
    user: any;
    id?: number;
    orderDate?: string;
    deleteStatus?: number;
    paymentStatus?: number;
    totalMoney?: number;
    productOrderDetailSet: any;
}
