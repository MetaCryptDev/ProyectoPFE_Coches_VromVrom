import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cita } from '../dto/cita';

@Injectable({
  providedIn: 'root'
})
export class CitaService {

  constructor(private http : HttpClient) { }

  private urlEndPoint : string = 'http://localhost:8080/cita/';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  findAll() : Observable<Cita[]> {
    return this.http.get<Cita[]>(this.urlEndPoint + 'verTodos');
  }

  saveCita(cita : Cita) : Observable<Cita> {
    return this.http.post<Cita>(this.urlEndPoint + 'insertar', cita, {headers: this.httpHeaders});
  }

  removeCita(idCita: number) : Observable<Cita> {
    return this.http.delete<Cita>(this.urlEndPoint + 'eliminar/' + idCita, {headers: this.httpHeaders});
  }

  findById(idCita : number) : Observable<Cita> {
    return this.http.get<Cita>(this.urlEndPoint + 'recuperarUnaCita/' + idCita);
  }

  updateCita(cita: Cita) : Observable<Cita> {
    return this.http.put<Cita>(this.urlEndPoint + 'actualizar/' + cita.idCita, cita, {headers: this.httpHeaders});
  }

  getHorasDisponibles(idServicio: number, fecha: string): Observable<string[]> {
    // Construye la URL manualmente
    const url = `${this.urlEndPoint}horasDisponibles?idServicio=${idServicio}&fecha=${fecha}`;
    alert(url);  // Solo para debugging, puedes quitarlo después
    return this.http.get<string[]>(url, {headers: this.httpHeaders});
}

}
