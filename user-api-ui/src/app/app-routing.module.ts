import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
 
const routes: Routes = [
  { path: 'user-list', component: UserListComponent },
  { path: 'user-add', component: UserFormComponent },
  { path: 'user-edit/:id', component: UserFormComponent },
  { path: '', redirectTo: '/user-list', pathMatch: 'full' }
];
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }