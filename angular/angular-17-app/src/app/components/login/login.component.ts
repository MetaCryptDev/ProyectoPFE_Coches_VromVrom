import { Component, NgModule, OnInit } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { UsuarioService } from '../../servicios/usuario-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Usuario } from '../../dto/usuario';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FooterComponent,FormsModule,HttpClientModule],
  templateUrl: './login.component.html',
  styleUrls: ['../../../assets/css/custom.css','../../../assets/css/templatemo.css','../../../assets/css/fontawesome.css','../../../assets/css/fontawesome.min.css',"../../../assets/css/login.css"]
})
export class LoginComponent implements OnInit {

  title : string = 'Nuevo usuario';

    usuario : Usuario = new Usuario();

    constructor(private usuarioService : UsuarioService,
                private router : Router,
                private activatedRouter : ActivatedRoute) {}

    ngOnInit(): void {
     this.cargarUsuario();
    }

    cargarUsuario() : void {
      this.activatedRouter.params.subscribe(
        params => {
          let id = params['id']
          if (id) {
            this.usuarioService.findById(id).subscribe(
              (usuario) => {
                
                this.title= 'Modificar Producto'
                this.usuario = usuario
              }
            )
          }
        }
      );
    }

    crearUsuario() : void {
      this.usuarioService.saveUsuario(this.usuario).subscribe(
        response => {
           alert(this.usuario);
            
        }
      );
    }

    actualizarUsuario() : void {
      this.usuarioService.updateUsuario(this.usuario).subscribe(
        response => {
          this.router.navigate(['/listadoProductos'])
         
        }
      );
    }

}
