import { Address } from "./address";

export interface User {
    id: number;
    avatar: string;
    birthday: string;
    email: string;
    firstName: string;
    lastName: string;
    idCard: string;
    phone: string;
    deleteStatus: number;
    addressSet: Address[];
}
