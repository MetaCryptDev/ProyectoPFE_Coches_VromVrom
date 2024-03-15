import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrls: ['../assets/css/custom.css','../assets/css/templatemo.css','../assets/css/bootstrap.min.css','../assets/css/fontawesome.css'],
})
export class AppComponent {
  title = 'angular-17-app';
  imagen = "../imagenes/logo.png"
}
