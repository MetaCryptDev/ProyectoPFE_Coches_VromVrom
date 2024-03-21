import { Component, NgModule, } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { UsuarioService } from '../../servicios/usuario-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Usuario } from '../../dto/usuario';

@Component({
  selector: 'app-usuarios-crear',
  standalone: true,
  imports: [FooterComponent, FormsModule, HttpClientModule, RouterModule],
  templateUrl: './usuarios-crear.component.html',
  styleUrls: ['../../../assets/css/custom.css', '../../../assets/css/templatemo.css', '../../../assets/css/fontawesome.css', '../../../assets/css/fontawesome.min.css']
})
export class UsuariosCrearComponent {

  title: string = 'Nuevo usuario';

  usuario: Usuario = new Usuario();
  usuarioRecogido: Usuario | undefined;
  editar: number = 0;

  

  constructor(private usuarioService: UsuarioService, private router: Router, private activatedRoute: ActivatedRoute) {
    const navigation = this.router.getCurrentNavigation();
    
    if (navigation && navigation.extras && navigation.extras.state) {
        this.usuarioRecogido = navigation.extras.state['usuarioRecogido'] as Usuario | undefined;
    }
}

  loadScript(src: string) {
    const script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = src;
    document.body.appendChild(script);
  }

  crearUsuario(): void {
    this.usuarioService.saveUsuario(this.usuario).subscribe(
      response => {
        this.router.navigate(['']);

      }
    );
  }

  actualizarUsuario(): void {
    this.usuarioService.updateUsuario(this.usuario).subscribe(
      response => {
        this.router.navigate(['/listadoUsuarios'])
       
      }
    );
  } 
}
