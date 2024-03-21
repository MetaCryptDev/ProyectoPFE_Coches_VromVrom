import { Component, OnInit } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { IndexComponent } from './components/index/index.component';
import { HttpClientModule } from '@angular/common/http';
import { Usuario } from '../app/dto/usuario';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, IndexComponent, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrls: ['../assets/css/custom.css', '../assets/css/templatemo.css', '../assets/css/fontawesome.css', '../assets/css/fontawesome.min.css'],
})
export class AppComponent implements OnInit {

  isLoggedIn = false;
  mecanico = false;
  admin = false;
  title = 'angular-17-app';
  imagen = "../imagenes/logo.png"

  ngOnInit(): void {
    const currentUser = localStorage.getItem('currentUser');
    this.isLoggedIn = !!currentUser;
    if (currentUser) {
      const userData: Usuario = JSON.parse(currentUser);
      this.admin = userData.rol === 2;
      this.mecanico = userData.rol === 1;
    } else {
      this.mecanico = false;
      this.admin = false;
    }
  }

  logout(): void {
    localStorage.removeItem('currentUser');
    window.location.reload();
  }

}
