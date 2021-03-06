/*
 * Lisans bilgisi icin lutfen proje ana dizinindeki zemberek2-lisans.txt dosyasini okuyunuz.
 */

package net.zemberek.tk.yapi;

import static net.zemberek.tk.yapi.ek.TurkmenceEkAdlari.AT_SADA_BOS;
import static net.zemberek.tk.yapi.ek.TurkmenceEkAdlari.CALISMA_SADA_BOS;
import static net.zemberek.tk.yapi.ek.TurkmenceEkAdlari.HASAT_SADA_BOS;
import static net.zemberek.tk.yapi.ek.TurkmenceEkAdlari.ISLIK_SADA_BOS;
import static net.zemberek.tk.yapi.ek.TurkmenceEkAdlari.SAN_SADA_BOS;
import static net.zemberek.tk.yapi.ek.TurkmenceEkAdlari.ZAMAN_SADA_BOS;
import static net.zemberek.yapi.KelimeTipi.BAGLAC;
import static net.zemberek.yapi.KelimeTipi.EDAT;
import static net.zemberek.yapi.KelimeTipi.FIIL;
import static net.zemberek.yapi.KelimeTipi.HATALI;
import static net.zemberek.yapi.KelimeTipi.IMEK;
import static net.zemberek.yapi.KelimeTipi.ISIM;
import static net.zemberek.yapi.KelimeTipi.KISALTMA;
import static net.zemberek.yapi.KelimeTipi.OZEL;
import static net.zemberek.yapi.KelimeTipi.SAYI;
import static net.zemberek.yapi.KelimeTipi.SIFAT;
import static net.zemberek.yapi.KelimeTipi.SORU;
import static net.zemberek.yapi.KelimeTipi.UNLEM;
import static net.zemberek.yapi.KelimeTipi.YANKI;
import static net.zemberek.yapi.KelimeTipi.ZAMAN;
import static net.zemberek.yapi.KelimeTipi.ZAMIR;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.zemberek.tk.islemler.TurkmenceCozumlemeYardimcisi;
import net.zemberek.tk.yapi.ek.EkUreticiTm;
import net.zemberek.tk.yapi.ek.TurkmenceEkOzelDurumUretici;
import net.zemberek.tk.yapi.kok.TurkmenceKokOzelDurumBilgisi;
import net.zemberek.yapi.Alfabe;
import net.zemberek.yapi.DilAyarlari;
import net.zemberek.yapi.KelimeTipi;
import net.zemberek.yapi.ek.EkKuralBilgisi;
import net.zemberek.yapi.ek.EkOzelDurumUretici;
import net.zemberek.yapi.ek.EkUretici;
import net.zemberek.yapi.ek.TemelEkUretimKurali;
import net.zemberek.yapi.ek.TemelEkYonetici;

/**
 * User: ahmet
 * Date: Sep 6, 2005
 */
public class Turkmence implements DilAyarlari {

    public Locale locale() {
        return new Locale("tk");
    }

    public Class<Alfabe> alfabeSinifi() {
        return Alfabe.class;
    }

    public Class<TemelEkYonetici> ekYoneticiSinifi() {
        return TemelEkYonetici.class;
    }

    public Class<TurkmenceHeceleyici> heceleyiciSinifi() {
        return TurkmenceHeceleyici.class;
    }

    public Class<TurkmenceKokOzelDurumBilgisi> kokOzelDurumBilgisiSinifi() {
        return TurkmenceKokOzelDurumBilgisi.class;
    }

    public Class<TurkmenceCozumlemeYardimcisi> cozumlemeYardimcisiSinifi() {
        return TurkmenceCozumlemeYardimcisi.class;
    }

    public String[] duzYaziKokDosyalari() {
        return new String[]{"kaynaklar/tk/bilgi/kokler.txt"};
    }

    public EkKuralBilgisi ekKuralBilgisi() {
        return new TemelEkUretimKurali.TemelKuralBilgisi();
    }    

    public Map<String, KelimeTipi> kokTipiAdlari() {
        Map<String, KelimeTipi> kokTipAdlari = new HashMap<String, KelimeTipi>();
        kokTipAdlari.put("AT", ISIM);
        kokTipAdlari.put("ISH", FIIL);
        kokTipAdlari.put("SI", SIFAT);
        kokTipAdlari.put("SA", SAYI);
        kokTipAdlari.put("YA", YANKI);
        kokTipAdlari.put("ZA", ZAMIR);
        kokTipAdlari.put("SO", SORU);
        kokTipAdlari.put("IM", IMEK);
        kokTipAdlari.put("ZAMAN", ZAMAN);
        kokTipAdlari.put("HATALI", HATALI);
        kokTipAdlari.put("EDAT", EDAT);
        kokTipAdlari.put("BAGLAC", BAGLAC);
        kokTipAdlari.put("OZ", OZEL);
        kokTipAdlari.put("UN", UNLEM);
        kokTipAdlari.put("KI", KISALTMA);
        return kokTipAdlari;
    }

    public Map<KelimeTipi, String> baslangiEkAdlari() {
        Map<KelimeTipi, String> baslangicEkAdlari = new EnumMap<KelimeTipi, String>(KelimeTipi.class);
        baslangicEkAdlari.put(ISIM, AT_SADA_BOS);
        baslangicEkAdlari.put(SIFAT, AT_SADA_BOS);
        baslangicEkAdlari.put(FIIL, ISLIK_SADA_BOS);
        baslangicEkAdlari.put(ZAMAN, ZAMAN_SADA_BOS);
        baslangicEkAdlari.put(ZAMIR, CALISMA_SADA_BOS);
        baslangicEkAdlari.put(SAYI, SAN_SADA_BOS);
        baslangicEkAdlari.put(OZEL, HASAT_SADA_BOS);
        return baslangicEkAdlari;
    }

    public String ad() {
        return "TURKMENCE";
    }

    public EkUretici ekUretici(Alfabe alfabe) {
        return new EkUreticiTm(alfabe);
    }

    public EkOzelDurumUretici ekOzelDurumUretici(Alfabe alfabe) {
        return new TurkmenceEkOzelDurumUretici(alfabe);
    }
}
