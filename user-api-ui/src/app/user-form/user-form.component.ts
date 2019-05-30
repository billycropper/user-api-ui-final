import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../user-service.service';
import { User } from '../user';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  user: User = {id: 0, name: '', username: '', email: '', phone: '', website: '', address: {street: '', suite: '', zipcode: '', city: '', geo: {lat: '', lng: ''}}, company: {name: '', catchPhrase: '', bs: ''}};
  sub: Subscription;

  constructor(private route: ActivatedRoute, private router: Router, private userServiceService: UserServiceService) {
    
  }

  save() {
    return this.userServiceService.save(this.user).subscribe(result => {
      this.gotoUserList();
    })
  }

  delete() {
    return this.userServiceService.delete(this.user.id).subscribe(result => {
      this.gotoUserList();
    })
  }

  gotoUserList() {
    this.router.navigate(['/user-list']);
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if(id){
        this.userServiceService.find(id).subscribe((user: User) => {
          if (user) {
            this.user = user;
          } else {
            console.log(`Person not found with id, '${id}' returning to list`);
            this.gotoUserList();
          }
        })
      }
    })
  }

}