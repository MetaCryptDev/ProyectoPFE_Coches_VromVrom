import { Component, NgModule, } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { UsuarioService } from '../../servicios/usuario-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Usuario } from '../../dto/usuario';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FooterComponent, FormsModule, HttpClientModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrls: ['../../../assets/css/custom.css', '../../../assets/css/templatemo.css', '../../../assets/css/fontawesome.css', '../../../assets/css/fontawesome.min.css', "../../../assets/css/login.css"]
})
export class LoginComponent {

  title: string = 'Nuevo usuario';

  usuario: Usuario = new Usuario();

  constructor(private usuarioService: UsuarioService,
    private router: Router,
    private activatedRouter: ActivatedRoute) { }

  ngOnInit() {
    this.loadScript("../../../assets/js/login.js")
  }

  loadScript(src: string) {
    const script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = src;
    document.body.appendChild(script);
  }

  login(): void {
    this.usuarioService.login(this.usuario.nombre, this.usuario.passwd).subscribe(
      data => {
        localStorage.setItem('currentUser', JSON.stringify(data));
        window.location.href = '';
      },
      error => {
        alert("usuario o contraseña no encontrado")
      }
    );
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
        this.router.navigate(['/listadoProductos'])

      }
    );
  }

}
