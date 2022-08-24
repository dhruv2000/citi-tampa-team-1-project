import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl: string = 'http://tampa-team-project-1-tampa-team-project-1.openshift21.conygre.com/api/orders';

  constructor(private http: HttpClient) { }

getOrders(): Observable<Array<Order>>  {
    return this.http.get(this.baseUrl) as Observable<Array<Order>>;
}

// getOrderById(id: number): Observable<Order> {
//     return this.http.get(`${this.baseUrl}/${id}`) as Observable<Order>;
// }

}
