package com.beadando.exceptions;

public class KeszultDbRossz extends Throwable {
    public KeszultDbRossz(int keszultdb){
        super(String.valueOf(keszultdb));
    }
}
