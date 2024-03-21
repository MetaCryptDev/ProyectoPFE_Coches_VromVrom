import { Routes } from '@angular/router';
import { app } from '../../server';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { IndexComponent } from './components/index/index.component';
import { CitaComponent } from './components/cita/cita.component';
import { InventarioComponent } from './components/inventario/inventario.component';
import { UsuariosListaComponent } from './components/usuarios-lista/usuarios-lista.component';

export const routes: Routes = [{
    path:"", title:"Talleres YoDa", component: IndexComponent
},
{
    path:"login",title:"Registro", component: LoginComponent
},

{
    path:"cita",title:"Pedir Cita", component: CitaComponent
},

{
    path:"inventario",title:"Mostrar Inventario", component: InventarioComponent
},
{
    path:"listUsuario",title:"Usuarios", component: UsuariosListaComponent
}

];
