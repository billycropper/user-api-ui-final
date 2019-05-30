import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../app/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private usersUrl: string;
 
  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/user/';
  }
 
  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }
 
  public save(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl, user);
  }

  public delete(id: number): Observable<any>{
    return this.http.delete<User>(this.usersUrl + id);
  }

  public find(id: number){
    return this.http.get(this.usersUrl + id);
  }

  public update(id: number, value: any) {
    return this.http.put(this.usersUrl + id, value);
  }
}
