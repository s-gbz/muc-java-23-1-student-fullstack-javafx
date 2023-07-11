package de.neuefische.studentdbbackend.util;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MatriculationNumberService {

    private final Random random = new Random();

    public String generateMatriculationNumber() {
        int zufallszahl = random.nextInt(800000) + 100000;
        return "MN-" + zufallszahl;
    }

}
