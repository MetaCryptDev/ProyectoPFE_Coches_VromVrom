import { Component, OnInit } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { Contacto } from '../../dto/contacto';
import { ContactoService } from '../../servicios/contacto-service.service copy';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-cita',
  standalone: true,
  imports: [FooterComponent,FormsModule,RouterModule],
  templateUrl: './cita.component.html',
  styleUrls: ['./cita.component.css','../../../assets/css/custom.css','../../../assets/css/templatemo.css','../../../assets/css/fontawesome.css','../../../assets/css/fontawesome.min.css']
  
})
export class CitaComponent implements OnInit {
  title : string = 'Nuevo contacto';

  contacto : Contacto = new Contacto();

  constructor(private contactoService : ContactoService,
              private router : Router,
              private activatedRouter : ActivatedRoute) {}

  ngOnInit(): void {
    const currentUser = localStorage.getItem('currentUser');
  if (currentUser) {
    let userData = JSON.parse(currentUser);
    this.contacto.nombre = userData.nombre;
    this.contacto.mail = userData.mail;
  }
  }
}