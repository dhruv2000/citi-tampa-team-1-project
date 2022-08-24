import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {

  orders!: Observable<Array<Order>>;

  constructor(private orderService: OrderService) { 
   
  }

  ngOnInit(): void {
    this.orders = this.orderService.getOrders();
  }

}
