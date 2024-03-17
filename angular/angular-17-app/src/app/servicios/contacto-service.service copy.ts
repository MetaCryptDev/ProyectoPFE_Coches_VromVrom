import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contacto } from '../dto/contacto';

@Injectable({
  providedIn: 'root'
})
export class ContactoService {

  constructor(private http : HttpClient) { }

  private urlEndPoint : string = 'http://localhost:8080/contacto/';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  findAll() : Observable<Contacto[]> {
    return this.http.get<Contacto[]>(this.urlEndPoint + 'verTodos');
  }

  saveContacto(contacto : Contacto) : Observable<Contacto> {
    alert(contacto.mail+" "+contacto.nombre+" "+contacto.motivo+" "+contacto.mensaje)
    return this.http.post<Contacto>(this.urlEndPoint + 'insertar', contacto, {headers: this.httpHeaders});
  }

  removeContacto(idContacto: number) : Observable<Contacto> {
    return this.http.delete<Contacto>(this.urlEndPoint + 'eliminar/' + idContacto, {headers: this.httpHeaders});
  }

  findById(idContacto : number) : Observable<Contacto> {
    return this.http.get<Contacto>(this.urlEndPoint + 'recuperarUnUsuario/' + idContacto);
  }

  updateUContacto(contacto: Contacto) : Observable<Contacto> {
    return this.http.put<Contacto>(this.urlEndPoint + 'actualizar/' + contacto.idContacto, contacto, {headers: this.httpHeaders});
  }

}
