import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseUrl = 'http://localhost:8082/room';

  constructor(private http: HttpClient) { }

  getRoomsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getRoom(id: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/${id}`);
  }

 // createRoom(room: Object): Observable<Object>{
  //  return this.http.post(`${this.baseUrl}`, room);
 // }
 createRoom(room: Object): Observable<Object> {
  return this.http.post(`${this.baseUrl}`, room);
 }

 uodateRoom(room: Object): Observable<Object> {
  return this.http.put(`${this.baseUrl}`, room);
  }

  deleteRoom(room:Object): Observable<Object>{
    return this.http.delete(`${this.baseUrl}`, room);

  }




}
