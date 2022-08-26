import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { FormBuilder } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {

  orders!: Observable<Array<Order>>;

  checkoutForm = this.formBuilder.group({
    ticker: '',
    asset: '',
    price: null,
    status_code: 0,
    num_shares: null,
    order_type: '',
    time_of_day: ''
  });

  constructor(private orderService: OrderService, private formBuilder: FormBuilder, private router: Router) {

  }

  format = (input: number, padLength: number): string => {
    return input.toString().padStart(padLength, '0');
  };

  getDate(): string {
    const date = new Date();
    
    const dateTimeNow =
      this.format(date.getFullYear(), 4) +
      '-' +
      this.format(date.getMonth() + 1, 2) +
      '-' +
      this.format(date.getDate(), 2) +
      ' ' +
      this.format(date.getHours(), 2) +
      ':' +
      this.format(date.getMinutes(), 2) +
      ':' +
      this.format(date.getSeconds(), 2);
      // 2022-03-14 14:20:29
      console.log(dateTimeNow);
      return dateTimeNow;
  }
  

  async onSubmit(): Promise<void> {
    console.log(this.checkoutForm.value);
    let form = this.checkoutForm.value;
    const tempAddOrder = new Order(
      0,
      form.ticker,
      form.price,
      form.status_code,
      form.num_shares,
      form.order_type,
      this.getDate(),
      form.asset
      );
    await this.orderService.addOrder(tempAddOrder);
    this.router.navigateByUrl('/viewhistory');
    this.orderService.orderFullfillment()
    // this.router.navigate(['/viewhistory']);
  }

  ngOnInit(): void {
    this.orders = this.orderService.getOrders();
    // const tempAddOrder = new Order(1, "FB", 321.67, 0, 345, "buy", "2021-09-12 14:02:29", "stock");
    // this.orderService.addOrder(tempAddOrder);

    // const tempUpdateOrder = new Order(3, "FB", 111.11, 0, 888, "sell", "2021-09-12 14:02:29", "stock");
    // this.orderService.updateOrder(tempUpdateOrder);
  }

}
