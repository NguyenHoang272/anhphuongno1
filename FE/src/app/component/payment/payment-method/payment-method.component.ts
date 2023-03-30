import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { render } from 'creditcardpayments/creditCardPayments';
import { ToastrService } from 'ngx-toastr';
import { OrderService } from 'src/app/service/order/order.service';

@Component({
  selector: 'app-payment-method',
  templateUrl: './payment-method.component.html',
  styleUrls: ['./payment-method.component.css']
})
export class PaymentMethodComponent implements OnInit {

  constructor(
    private toastr: ToastrService,
    private router: Router,
    private orderService: OrderService
  ) {
  }

  ngOnInit(): void {
    const totalMoneyUSD: string = JSON.stringify(this.orderService.totalMoneyUSD);
    render({
      id: '#myPaypalButton',
      currency: 'USD',
      value: totalMoneyUSD,
      onApprove: (details) => {
        this.orderService.updatePaymentStatus().subscribe(() => {
          this.toastr.success('Giao dịch thành công');
          this.router.navigateByUrl('').then(() => {
            document.getElementById("reloadHeaderViewCart").click();
          });
        })
      }
    }) 
  }

}
