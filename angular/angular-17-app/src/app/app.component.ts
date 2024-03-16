import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { IndexComponent } from './components/index/index.component';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink,IndexComponent],
  templateUrl: './app.component.html',
  styleUrls: ['../assets/css/custom.css','../assets/css/templatemo.css','../assets/css/fontawesome.css','../assets/css/fontawesome.min.css'],
})
export class AppComponent {
  title = 'angular-17-app';
  imagen = "../imagenes/logo.png"
  
}
