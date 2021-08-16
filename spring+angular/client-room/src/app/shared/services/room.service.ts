import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseUrl = 'http://localhost:8080/api/v1/rooms';

  constructor(private http: HttpClient) { }

  getRoom(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createRoom(room: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, room);
  }

  updateRoom(id: number, room: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, room);
  }

  deleteRoom(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getRoomsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
