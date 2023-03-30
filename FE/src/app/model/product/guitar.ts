import { Product } from "./product";

export interface Guitar {
  id?: number;
  bodyWood?: string;
  bodyColor?: string;
  neckMaterial?: string;
  neckCurvature?: string;
  scaleLength?: string;
  neckInlay?: string;
  guitarBridge?: string;
  guitarNut?: string;
  guitarString?: string;
  hardwareFinish?: string;
  guitarBag?: string;
  numberOfFrets?: string;
  guitarPickups?: string;
  guitarPickGuards?: string;
  tuningMachine?: string;
  deleteStatus?: number;
  product?: Product;
}
