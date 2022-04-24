/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.revisa.teste.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

/**
 *
 * @author Renan
 */
public class Conversoes {

    public static String converterData(Date data) {
        if (data == null) {
            return "";
        }
        String formato = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        return formatter.format(data);
    }

    public static String converterHora(Date data) {
        String formato = "HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        return formatter.format(data);
    }

    public static String converterDataHora(Date data) {
        String formato = "dd/MM/yyyy HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        return formatter.format(data);
    }

    public static String converterDataAmericano(Date date) {
        String formato = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        return formatter.format(date);

    }

    public static String converterDataHoraPasta(Date date) {
        String formato = "dd-MM-yyyy-HH-mm-ss";
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        return formatter.format(date);

    }

    public static String converterDataHoraAmericano(Date date) {
        String formato = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        return formatter.format(date);

    }

    public static String converterDoubleMoeda(double valor) {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(); //Formato de moeda atual do sistema
        return formatoMoeda.format(valor);
    }

    public static String converteCpfCnpj(String cpfCnpj) {
        if (cpfCnpj.length() < 12) {
            return formatar(cpfCnpj, "###.###.###-##");
        } else {
            return formatar(cpfCnpj, "##.###.###/####-##");
        }

    }

    public static String formatar(String valor, String mascara) {

        String dado = "";
        // remove caracteres nao numericos
        for (int i = 0; i < valor.length(); i++) {
            char c = valor.charAt(i);
            if (Character.isDigit(c)) {
                dado += c;
            }
        }

        int indMascara = mascara.length();
        int indCampo = dado.length();

        for (; indCampo > 0 && indMascara > 0;) {
            if (mascara.charAt(--indMascara) == '#') {
                indCampo--;
            }
        }

        String saida = "";
        for (; indMascara < mascara.length(); indMascara++) {
            saida += ((mascara.charAt(indMascara) == '#') ? dado.charAt(indCampo++) : mascara.charAt(indMascara));
        }
        return saida;
    }

    public static Date converterStringToDateAmericano(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date) formatter.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    public static Date converterStringToDate(String data, String pattern) {
        if (data == null || data.equals("")) {
            return null;
        }

        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat(pattern);
            date = (java.util.Date) formatter.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    public static String converterStringAmericanoToStringBrasilData(String data) {
        if (data == null) {
            return "";
        }
        if (data.length() != 8) {
            return data;
        }

        StringBuilder retorno = new StringBuilder();
        retorno.append(data.substring(6, 8));
        retorno.append("/");
        retorno.append(data.substring(4, 6));
        retorno.append("/");
        retorno.append(data.substring(0, 4));

        return retorno.toString();
    }

}
