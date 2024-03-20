import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { Contacto } from '../../dto/contacto';
import { ContactoService } from '../../servicios/contacto-service.service';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CitaService } from '../../servicios/cita-service.service';
import { HttpClientModule } from '@angular/common/http';
import { Cita } from '../../dto/cita';
import { Usuario } from '../../dto/usuario';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cita',
  standalone: true,
  imports: [FooterComponent, FormsModule, RouterModule, CommonModule],
  templateUrl: './cita.component.html',
  styleUrls: ['./cita.component.css', '../../../assets/css/custom.css', '../../../assets/css/templatemo.css', '../../../assets/css/fontawesome.css', '../../../assets/css/fontawesome.min.css']
})
export class CitaComponent implements OnInit {
  title: string = 'Nuevo Cita';
  horasDisponibles: string[] = [];
  user: Usuario = new Usuario();
  contacto: Contacto = new Contacto();
  cita: Cita = new Cita();
  vehiculoSustBool: boolean = false;

  constructor(private citaService: CitaService,
    private router: Router,
    private activatedRouter: ActivatedRoute,
    private changeDetectorRef: ChangeDetectorRef) {}

  ngOnInit(): void {
    const currentUser = localStorage.getItem('currentUser');
    if (currentUser) {
      let userData = JSON.parse(currentUser);
      this.contacto.nombre = userData.nombre;
      this.contacto.mail = userData.mail;
      this.cita.idUsuario = userData.idUsuario;
    }
    const inputDateElement = document.getElementById("date");
    if (inputDateElement) {
      const today = new Date();
      today.setDate(today.getDate() + 1); // Añade un día al día actual
      const tomorrow = today.toISOString().split('T')[0];
      inputDateElement.setAttribute("min", tomorrow);
    }
  }

  toggleVehiculoSustitucion() {
    this.vehiculoSustBool = !this.vehiculoSustBool;
    const vehiculoSustDiv = document.getElementById("vehiculoSustDiv");
    if (vehiculoSustDiv) {
      vehiculoSustDiv.style.display = this.vehiculoSustBool ? "block" : "none";
    }
  }
  

  crearCita(): void {
    this.cita.entrada = `${this.cita.fecha}T${this.cita.hora}`;
    console.log('Enviando cita:', JSON.stringify(this.cita));
    this.citaService.saveCita(this.cita).subscribe(
      response => {
        this.router.navigate(['']);
      }
    );
  }

  actualizarHorasDisponibles() {
    if (this.cita.idServicio && this.cita.fecha) {
      this.citaService.getHorasDisponibles(this.cita.idServicio, this.cita.fecha)
        .subscribe(
          horas => {
            this.horasDisponibles = horas;
          },
          error => {
            console.error('Error al recuperar las horas disponibles:', error);
            this.horasDisponibles = []; // Limpiar las horas si hay un error
          }
        );
    }
  }
}
