import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-history-table',
  templateUrl: './order-history-table.component.html',
  styleUrls: ['./order-history-table.component.css']
})
export class OrderHistoryTableComponent implements OnInit {

  orders!: Observable<Array<Order>>;

  constructor(private orderService: OrderService) { 


  }
  

  ngOnInit(): void {
    this.orders = this.orderService.getOrders();
  }

}
