package it.unimi.di.prog2.e06;

/**
 * Genera eccezione
 * @extends Exception
 */
public class NotFoundException extends Exception {
    private static final long serialVersionUID = 1L; 
    public NotFoundException() {super();}
    public NotFoundException(String message) {super(message);}
  }  
