package com.proyectojm.app.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojm.app.dao.IDAOCita;
import com.proyectojm.app.dto.CitaDto;
import com.proyectojm.app.dto.ServicioDto;
import com.proyectojm.app.dto.UsuarioDto;
import com.proyectojm.app.dto.VehiculoDto;
import com.proyectojm.app.dto.VehiculoSustitucionDto;
import com.proyectojm.app.entities.CitaEntity;
import com.proyectojm.app.entities.ServicioEntity;
import com.proyectojm.app.entities.UsuarioEntity;
import com.proyectojm.app.entities.VehiculoEntity;
import com.proyectojm.app.entities.VehiculoSustitucionEntity;
import com.proyectojm.app.service.IServiceCita;

@Service
public class CitaServiceImpl implements IServiceCita {

    @Autowired
    private IDAOCita citaDao;

    @Override
    public void guardarCita(CitaDto cita) {
    	CitaEntity citaEntty = new CitaEntity();
    	UsuarioEntity usuarioEntty = new UsuarioEntity();
    	VehiculoEntity vehiculoEntty = new VehiculoEntity();
    	ServicioEntity servicioEntty = new ServicioEntity();
    	VehiculoSustitucionEntity vehiculoSustitucionEntty = new VehiculoSustitucionEntity();
    	
		try {

			citaEntty.setIdCita(cita.getIdCita());
			citaEntty.setEntrada(cita.getEntrada());
			
			
			if(cita.getUsuario()!=null) {
				
				usuarioEntty.setIdUsuario(cita.getUsuario().getIdUsuario());
				usuarioEntty.setNombre(cita.getUsuario().getNombre());
				usuarioEntty.setApellido(cita.getUsuario().getApellido());
				usuarioEntty.setMail(cita.getUsuario().getMail());
				usuarioEntty.setPasswd(cita.getUsuario().getPasswd());
				usuarioEntty.setTelefono(cita.getUsuario().getPasswd());
				citaEntty.setUsuario(usuarioEntty);
				
			}
			
			if(cita.getVehiculo()!=null) {
				
				vehiculoEntty.setMatricula(cita.getVehiculo().getMatricula());
				vehiculoEntty.setMarca(cita.getVehiculo().getMarca());
				vehiculoEntty.setModelo(cita.getVehiculo().getModelo());
				//vehiculoEntty.setUsuario(cita.getVehiculo().getUsuario());
				citaEntty.setVehiculo(vehiculoEntty);
			}
			
			
			if(cita.getIdServicio()!=null) {
				
				servicioEntty.setIdServicio(cita.getServicio().getIdServicio());
				servicioEntty.setNombre(cita.getServicio().getNombre());
				servicioEntty.setManoDeObra(cita.getServicio().getManoDeObra());
				citaEntty.setServicio(servicioEntty);
				
			}
			
			if(cita.getVehiculoSustitucion()!=null) {
				vehiculoSustitucionEntty.setMarca(cita.getVehiculoSustitucion().getMarca());
				vehiculoSustitucionEntty.setMatricula(cita.getVehiculoSustitucion().getMatricula());
				vehiculoSustitucionEntty.setModelo(cita.getVehiculoSustitucion().getModelo());
				vehiculoSustitucionEntty.setPrecioPorDia(cita.getVehiculoSustitucion().getPrecioPorDia());
				vehiculoSustitucionEntty.setUrlImagen(cita.getVehiculoSustitucion().getUrlImagen());
				citaEntty.setVehiculoSustitucion(vehiculoSustitucionEntty);
				
			}
			
			if(cita.getDescripcionAveria()!=null) {
				citaEntty.setDescripcionAveria(cita.getDescripcionAveria());
				
			}
			
			
			citaDao.save(citaEntty);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

    @Override
    public void modificarCita(CitaDto cita) {
    	CitaEntity citaEntty = new CitaEntity();
    	UsuarioEntity usuarioEntty = new UsuarioEntity();
    	VehiculoEntity vehiculoEntty = new VehiculoEntity();
    	ServicioEntity servicioEntty = new ServicioEntity();
    	VehiculoSustitucionEntity vehiculoSustitucionEntty = new VehiculoSustitucionEntity();
    	
		try {

			citaEntty.setIdCita(cita.getIdCita());
			
			usuarioEntty.setIdUsuario(usuarioEntty.getIdUsuario());
			usuarioEntty.setNombre(usuarioEntty.getNombre());
			usuarioEntty.setApellido(usuarioEntty.getApellido());
			usuarioEntty.setMail(usuarioEntty.getMail());
			usuarioEntty.setPasswd(usuarioEntty.getPasswd());
			usuarioEntty.setTelefono(usuarioEntty.getPasswd());
			citaEntty.setUsuario(usuarioEntty);
			
			
			vehiculoEntty.setMatricula(vehiculoEntty.getMatricula());
			vehiculoEntty.setMarca(vehiculoEntty.getMarca());
			vehiculoEntty.setModelo(vehiculoEntty.getModelo());
			vehiculoEntty.setUsuario(vehiculoEntty.getUsuario());
			citaEntty.setVehiculo(vehiculoEntty);
			
		//	citaEntty.setEntrada(cita.getEntrada());
			
			
			servicioEntty.setIdServicio(servicioEntty.getIdServicio());
			servicioEntty.setNombre(servicioEntty.getNombre());
			servicioEntty.setManoDeObra(servicioEntty.getManoDeObra());
			citaEntty.setServicio(servicioEntty);
			
			
			vehiculoSustitucionEntty.setMarca(vehiculoSustitucionEntty.getMarca());
			vehiculoSustitucionEntty.setMatricula(vehiculoSustitucionEntty.getMatricula());
			vehiculoSustitucionEntty.setModelo(vehiculoSustitucionEntty.getModelo());
			vehiculoSustitucionEntty.setPrecioPorDia(vehiculoSustitucionEntty.getPrecioPorDia());
			vehiculoSustitucionEntty.setUrlImagen(vehiculoSustitucionEntty.getUrlImagen());
			citaEntty.setVehiculoSustitucion(vehiculoSustitucionEntty);
			
			citaEntty.setDescripcionAveria(cita.getDescripcionAveria());
			
			citaDao.save(citaEntty);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

    @Override
    public void eliminarCita(Integer id) {
    	CitaEntity cita = null;
        try {
            cita = citaDao.findById(id).orElse(null);
            if (cita != null) {
            	citaDao.delete(cita);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<CitaDto> recuperarTodasLasCitas() {
    	List<CitaDto> lstResultado = null;
        Iterable<CitaEntity> lstEntidades = null;

        try {
            lstResultado = new ArrayList<>();
            lstEntidades = citaDao.findAll();

            for (Iterator<CitaEntity> iterator = lstEntidades.iterator(); iterator.hasNext();) {
            	CitaEntity entity = iterator.next();
            	CitaDto actual = new CitaDto();
            	UsuarioDto usuario= new UsuarioDto();
				VehiculoDto vehiculo= new VehiculoDto();
				ServicioDto servicio= new ServicioDto();
            	VehiculoSustitucionDto vehiculoSustitucion = new VehiculoSustitucionDto();
            	
            	if(entity.getIdCita() != null) {
             //ID CITA
                actual.setIdCita(entity.getIdCita());
            	}
            	
                if(entity.getUsuario() != null) {
    		//USUARIO
                usuario.setIdUsuario(entity.getUsuario().getIdUsuario());
    			usuario.setNombre(entity.getUsuario().getNombre());
    			usuario.setApellido(entity.getUsuario().getApellido());
    			usuario.setMail(entity.getUsuario().getMail());
    			usuario.setPasswd(entity.getUsuario().getPasswd());
    			usuario.setTelefono(entity.getUsuario().getPasswd());
    			actual.setUsuario(usuario);
                }
                
                if(entity.getVehiculo() != null) {
            //VEHICULO
                vehiculo.setMarca(entity.getVehiculo().getMarca());
                vehiculo.setMatricula(entity.getVehiculo().getMatricula());
                vehiculo.setModelo(entity.getVehiculo().getModelo());
                vehiculo.setUsuario(usuario);
                actual.setVehiculo(vehiculo);
                }
                
                if(entity.getIdCita() != null) {
            //ENTRADA
             //   actual.setEntrada(entity.getEntrada());
                }
                
                if(entity.getServicio() != null) {
             //SERVICIO
    			servicio.setIdServicio(entity.getServicio().getIdServicio());
    			servicio.setNombre(entity.getServicio().getNombre());
    			servicio.setManoDeObra(entity.getServicio().getManoDeObra());
    			actual.setServicio(servicio);
                }
    			
                if (entity.getVehiculoSustitucion() != null) {
             //VEHICULO DE SUSTITUCION
    			vehiculoSustitucion.setMarca(entity.getVehiculoSustitucion().getMarca());
    			vehiculoSustitucion.setMatricula(entity.getVehiculoSustitucion().getMatricula());
    			vehiculoSustitucion.setModelo(entity.getVehiculoSustitucion().getModelo());
    			vehiculoSustitucion.setPrecioPorDia(entity.getVehiculoSustitucion().getPrecioPorDia());
    			vehiculoSustitucion.setUrlImagen(entity.getVehiculoSustitucion().getUrlImagen());
    			actual.setVehiculoSustitucion(vehiculoSustitucion);
                }
                
                if (entity.getDescripcionAveria() != null) {
             //VEHICULO DE SUSTITUCION
    			actual.setDescripcionAveria(actual.getDescripcionAveria());
            	}
                 
                lstResultado.add(actual);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lstResultado;
    }

    @Override
    public CitaDto recuperarUnaCita(Integer id) {
    	CitaDto actual = new CitaDto();
    	CitaEntity entity = null;
        UsuarioDto usuario= null;
		VehiculoDto vehiculo= null;
		ServicioDto servicio= null;
    	VehiculoSustitucionDto vehiculoSustitucion = null;
        try {
            entity = citaDao.findById(id).orElse(null);
            if (entity != null) {
            	if(entity.getUsuario() != null) {
    				//USUARIO
    				usuario = new UsuarioDto();
    				usuario.setIdUsuario(entity.getUsuario().getIdUsuario());
    				usuario.setNombre(entity.getUsuario().getNombre());
    				usuario.setApellido(entity.getUsuario().getApellido());
    				usuario.setTelefono(entity.getUsuario().getTelefono());
    				usuario.setMail(entity.getUsuario().getMail());
    				usuario.setPasswd(entity.getUsuario().getPasswd());
    				
                actual.setUsuario(usuario);
            	}
                
            	if(entity.getVehiculo() != null) {
                    //VEHICULO
            		vehiculo = new VehiculoDto();
                    vehiculo.setMarca(entity.getVehiculo().getMarca());
                    vehiculo.setMatricula(entity.getVehiculo().getMatricula());
                    vehiculo.setModelo(entity.getVehiculo().getModelo());
                    vehiculo.setUsuario(usuario);
                  
                actual.setVehiculo(vehiculo);
                        }
                        
                if(entity.getIdCita() != null) {
                    //ENTRADA
                //    actual.setEntrada(entity.getEntrada());
                    	}
                        
                if(entity.getServicio() != null) {
                    //SERVICIO
                	servicio = new ServicioDto();
            		servicio.setIdServicio(entity.getServicio().getIdServicio());
            		servicio.setNombre(entity.getServicio().getNombre());
            		servicio.setManoDeObra(entity.getServicio().getManoDeObra());
            		actual.setServicio(servicio);
                    	}
            			
                if (entity.getVehiculoSustitucion() != null) {
                    //VEHICULO DE SUSTITUCION
                	vehiculoSustitucion = new VehiculoSustitucionDto();
            		vehiculoSustitucion.setMarca(entity.getVehiculoSustitucion().getMarca());
            		vehiculoSustitucion.setMatricula(entity.getVehiculoSustitucion().getMatricula());
            		vehiculoSustitucion.setModelo(entity.getVehiculoSustitucion().getModelo());
            		vehiculoSustitucion.setPrecioPorDia(entity.getVehiculoSustitucion().getPrecioPorDia());
            		vehiculoSustitucion.setUrlImagen(entity.getVehiculoSustitucion().getUrlImagen());
            		actual.setVehiculoSustitucion(vehiculoSustitucion);
                        }
                        
                if (entity.getDescripcionAveria() != null) {
                    //VEHICULO DE SUSTITUCION
            		actual.setDescripcionAveria(actual.getDescripcionAveria());
                    	}
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actual;
    }
}
