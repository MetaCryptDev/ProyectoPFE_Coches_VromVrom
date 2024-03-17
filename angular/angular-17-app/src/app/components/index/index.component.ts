import { Component, NgModule, OnInit } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { Contacto } from '../../dto/contacto';
import { ContactoService } from '../../servicios/contacto-service.service copy';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-index',
  standalone: true,
  imports: [FooterComponent,HttpClientModule,RouterModule,FormsModule],
  templateUrl: './index.component.html',
  styleUrls: ['../../../assets/css/custom.css','../../../assets/css/templatemo.css','../../../assets/css/fontawesome.css','../../../assets/css/fontawesome.min.css']
})
export class IndexComponent implements OnInit {
  title : string = 'Nuevo contacto';

  contacto : Contacto = new Contacto();

  constructor(private contactoService : ContactoService,
              private router : Router,
              private activatedRouter : ActivatedRoute) {}

  ngOnInit(): void {
   this.cargarContacto();
  }

  cargarContacto() : void {
    this.activatedRouter.params.subscribe(
      params => {
        let id = params['id']
        if (id) {
          this.contactoService.findById(id).subscribe(
            (contacto) => {
              
              this.title= 'Modificar Contacto'
              this.contacto = contacto
            }
          )
        }
      }
    );
  }

  crearContacto() : void {
   
    this.contactoService.saveContacto(this.contacto).subscribe(
      response => {
         alert(this.contacto.mensaje);
          
      }
    );
  }

  actualizarContacto() : void {
    this.contactoService.updateUContacto(this.contacto).subscribe(
      response => {
        this.router.navigate(['/listadoContacto'])
       
      }
    );
  }

}
