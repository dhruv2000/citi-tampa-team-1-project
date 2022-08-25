import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-edit-orders',
  templateUrl: './edit-orders.component.html',
  styleUrls: ['./edit-orders.component.css']
})
export class EditOrdersComponent implements OnInit {

  orders!: Observable<Array<Order>>;

  constructor(private orderService: OrderService) { }
   
  remove(id: number)  {
    this.orderService.deleteOrderById(id);
    this.orders = this.orderService.getOrders();
  }

  ngOnInit(): void {
    this.orders = this.orderService.getOrders();
  }


}
