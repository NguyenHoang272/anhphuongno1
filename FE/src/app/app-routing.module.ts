import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartComponent } from './component/cart/cart.component';
import { LandingPageComponent } from './component/landing-page/landing-page.component';
import { PaymentMethodComponent } from './component/payment/payment-method/payment-method.component';
import { PaymentComponent } from './component/payment/payment.component';
import { ProductDetailComponent } from './component/product-detail/product-detail.component';
import { HistoryComponent } from './component/user-information/history/history.component';
import { UserInfoComponent } from './component/user-information/user-info/user-info.component';
import { UserInformationComponent } from './component/user-information/user-information.component';
import { UserGuard } from './security/guard/user.guard';


const routes: Routes = [
  {path: '', component: LandingPageComponent},
  {path: 'cart/:userId', component: CartComponent, canActivate: [UserGuard]},
  {path: 'payment/:userId', component: PaymentComponent, canActivate: [UserGuard],
  children: [
    {path: 'method', component: PaymentMethodComponent}
  ]},
  {path: 'product-detail/:productId', component: ProductDetailComponent},
  {path: 'user-info', component: UserInformationComponent, canActivate: [UserGuard],
  children: [
  {path: 'history', component: HistoryComponent},
  {path: 'user-info-detail', component: UserInfoComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
