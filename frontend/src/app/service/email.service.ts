import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EmailService {

  private baseUrl : string ="http://localhost:8080" ;

    constructor(private http:HttpClient) {}
    sendEmail (data:any):Observable<any>
    {
     return this.http.post<any>(`${this.baseUrl}/sendemail`,data)
    }
}
