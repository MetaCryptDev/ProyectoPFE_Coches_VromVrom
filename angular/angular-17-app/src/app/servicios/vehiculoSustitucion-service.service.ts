import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VehiculoSustitucion } from '../dto/vehiculoSustitucion';

@Injectable({
  providedIn: 'root'
})
export class VehiculoSustitucionService {

  constructor(private http: HttpClient) { }

  private urlEndPoint: string = 'http://localhost:8080/vehiculoSustitucion/';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  findAll(): Observable<VehiculoSustitucion[]> {
    return this.http.get<VehiculoSustitucion[]>(this.urlEndPoint + 'verTodos');
  }

  saveVehiculoSustitucion(vehiculoSustitucion: VehiculoSustitucion): Observable<VehiculoSustitucion> {
    return this.http.post<VehiculoSustitucion>(this.urlEndPoint + 'guardarVehiculoSustitucion', vehiculoSustitucion, {headers: this.httpHeaders});
  }

  removeVehiculoSustitucion(matricula: string): Observable<VehiculoSustitucion> {
    return this.http.delete<VehiculoSustitucion>(this.urlEndPoint + 'eliminarVehiculoSustitucion/' + matricula, {headers: this.httpHeaders});
  }

  findById(matricula: string): Observable<VehiculoSustitucion> {
    return this.http.get<VehiculoSustitucion>(this.urlEndPoint + 'recuperarUno/' + matricula);
  }

  updateVehiculoSustitucion(vehiculoSustitucion: VehiculoSustitucion): Observable<VehiculoSustitucion> {
    return this.http.put<VehiculoSustitucion>(this.urlEndPoint + 'modificarVehiculoSustitucion/' + vehiculoSustitucion.matricula, vehiculoSustitucion, {headers: this.httpHeaders});
  }
}
