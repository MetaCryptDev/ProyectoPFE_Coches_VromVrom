import { Routes } from '@angular/router';
import { app } from '../../server';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { IndexComponent } from './components/index/index.component';

export const routes: Routes = [{
    path:"", title:"Talleres YoDa", component: IndexComponent
},
{
    path:"login",title:"Registro", component: LoginComponent
}

];
