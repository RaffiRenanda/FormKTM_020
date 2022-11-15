/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PWS.A.KartuNikah;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author TUF GAMING
 */
@Controller
public class KONTROLku {
    @RequestMapping("/sayang")
    //@ResponseBody
    public String getData(
    @RequestParam("varNama")String text,
            @RequestParam("varPasangan") String pasangan,
            @RequestParam("varAlamat") String alamat,
            @RequestParam("varTanggal") @DateTimeFormat(pattern="yyyy-MM-dd") Date tanggal,
            @RequestParam("varFoto") MultipartFile foto,
            @RequestParam("varFoto2") MultipartFile foto2,
            Model jnt
    ) throws IOException{
        
        SimpleDateFormat newTanggal = new SimpleDateFormat("dd-MMMM-yyyy");
        String tanggalku = newTanggal.format(tanggal);
        
        String blob = Base64.encodeBase64String(foto.getBytes());
        String pict = "data:image/*;base64,".concat(blob);
        
        
        String blob2 = Base64.encodeBase64String(foto2.getBytes());
        String pict2 = "data:image/*;base64,".concat(blob2);
        //text = textProcess(text);
        
        jnt.addAttribute("sendnama", text);
        jnt.addAttribute("sendpasangan", pasangan);
        jnt.addAttribute("sendalamat", alamat);
        jnt.addAttribute("sendtanggal", tanggalku);
        jnt.addAttribute("sendgambar", pict);
        jnt.addAttribute("sendgambar2", pict2);
        
        return "view" ;
    }
}
