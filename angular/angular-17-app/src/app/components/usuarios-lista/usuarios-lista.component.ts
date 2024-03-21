import { Component, NgModule, } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { UsuarioService } from '../../servicios/usuario-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Usuario } from '../../dto/usuario';

@Component({
  selector: 'app-usuarios-lista',
  standalone: true,
  imports: [FooterComponent, FormsModule, HttpClientModule, RouterModule],
  templateUrl: './usuarios-lista.component.html',
  styleUrls: ['../../../assets/css/custom.css', '../../../assets/css/templatemo.css', '../../../assets/css/fontawesome.css', '../../../assets/css/fontawesome.min.css']
})


export class UsuariosListaComponent {
  title: string = 'Lista de usuarios';

  usuario: Usuario = new Usuario();

  listaUsuarios: Usuario[]= [];

  constructor(private usuarioService: UsuarioService,
    private router: Router,
    private activatedRouter: ActivatedRoute) { }

  loadScript(src: string) {
    const script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = src;
    document.body.appendChild(script);
  }

  buscarUsuarios(): void {
    this.usuarioService.findAll().subscribe(
      (response: Usuario[]) => {
        this.listaUsuarios = response;
      }
    );
  }

  eliminarUsuario() : void {
    this.usuarioService.removeUsuario(this.usuario.idUsuario).subscribe(
      response => {
        this.router.navigate(['/listadoUsuarios'])
       
      }
    );
  }
  
}
