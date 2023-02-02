package com.mx.mex.Dto;

public class MensajeDTO {
		private String mensajecorrecto;
		private String mensajeerror;
		
		private String mensajeRol;
		
		
		public String getMensajeRol() {
			return mensajeRol;
		}
		public void setMensajeRol(String mensajeRol) {
			this.mensajeRol = mensajeRol;
		}
		public String getMensajecorrecto() {
			return mensajecorrecto;
		}
		public void setMensajecorrecto(String mensajecorrecto) {
			this.mensajecorrecto = mensajecorrecto;
		}
		public String getMensajeerror() {
			return mensajeerror;
		}
		public void setMensajeerror(String mensajeerror) {
			this.mensajeerror = mensajeerror;
		}
}
