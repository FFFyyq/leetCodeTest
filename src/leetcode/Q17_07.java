package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Q17_07 {
    public static void main(String[] args) {
        String[] names = {"Fcclu(70)","Ommjh(63)","Dnsay(60)","Qbmk(45)","Unsb(26)","Gauuk(75)","Wzyyim(34)","Bnea(55)","Kri(71)","Qnaakk(76)","Gnplfi(68)","Hfp(97)","Qoi(70)","Ijveol(46)","Iidh(64)","Qiy(26)","Mcnef(59)","Hvueqc(91)","Obcbxb(54)","Dhe(79)","Jfq(26)","Uwjsu(41)","Wfmspz(39)","Ebov(96)","Ofl(72)","Uvkdpn(71)","Avcp(41)","Msyr(9)","Pgfpma(95)","Vbp(89)","Koaak(53)","Qyqifg(85)","Dwayf(97)","Oltadg(95)","Mwwvj(70)","Uxf(74)","Qvjp(6)","Grqrg(81)","Naf(3)","Xjjol(62)","Ibink(32)","Qxabri(41)","Ucqh(51)","Mtz(72)","Aeax(82)","Kxutz(5)","Qweye(15)","Ard(82)","Chycnm(4)","Hcvcgc(97)","Knpuq(61)","Yeekgc(11)","Ntfr(70)","Lucf(62)","Uhsg(23)","Csh(39)","Txixz(87)","Kgabb(80)","Weusps(79)","Nuq(61)","Drzsnw(87)","Xxmsn(98)","Onnev(77)","Owh(64)","Fpaf(46)","Hvia(6)","Kufa(95)","Chhmx(66)","Avmzs(39)","Okwuq(96)","Hrschk(30)","Ffwni(67)","Wpagta(25)","Npilye(14)","Axwtno(57)","Qxkjt(31)","Dwifi(51)","Kasgmw(95)","Vgxj(11)","Nsgbth(26)","Nzaz(51)","Owk(87)","Yjc(94)","Hljt(21)","Jvqg(47)","Alrksy(69)","Tlv(95)","Acohsf(86)","Qejo(60)","Gbclj(20)","Nekuam(17)","Meutux(64)","Tuvzkd(85)","Fvkhz(98)","Rngl(12)","Gbkq(77)","Uzgx(65)","Ghc(15)","Qsc(48)","Siv(47)"};
        String[] synonyms = {"(Gnplfi,Qxabri)","(Uzgx,Siv)","(Bnea,Lucf)","(Qnaakk,Msyr)","(Grqrg,Gbclj)","(Uhsg,Qejo)","(Csh,Wpagta)","(Xjjol,Lucf)","(Qoi,Obcbxb)","(Npilye,Vgxj)","(Aeax,Ghc)","(Txixz,Ffwni)","(Qweye,Qsc)","(Kri,Tuvzkd)","(Ommjh,Vbp)","(Pgfpma,Xxmsn)","(Uhsg,Csh)","(Qvjp,Kxutz)","(Qxkjt,Tlv)","(Wfmspz,Owk)","(Dwayf,Chycnm)","(Iidh,Qvjp)","(Dnsay,Rngl)","(Qweye,Tlv)","(Wzyyim,Kxutz)","(Hvueqc,Qejo)","(Tlv,Ghc)","(Hvia,Fvkhz)","(Msyr,Owk)","(Hrschk,Hljt)","(Owh,Gbclj)","(Dwifi,Uzgx)","(Iidh,Fpaf)","(Iidh,Meutux)","(Txixz,Ghc)","(Gbclj,Qsc)","(Kgabb,Tuvzkd)","(Uwjsu,Grqrg)","(Vbp,Dwayf)","(Xxmsn,Chhmx)","(Uxf,Uzgx)"};
        String[] res = new Q17_07().trulyMostPopular(names, synonyms);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ',');
        }
        System.out.println();
        String[] res1 = {"Npilye(25)","Drzsnw(87)","Fpaf(219)","Axwtno(57)","Avmzs(39)","Knpuq(61)","Avcp(41)","Naf(3)","Aeax(646)","Kgabb(236)","Chhmx(259)","Dwifi(237)","Ofl(72)","Nzaz(51)","Msyr(211)","Csh(238)","Kufa(95)","Ebov(96)","Onnev(77)","Chycnm(253)","Bnea(179)","Yjc(94)","Koaak(53)","Gauuk(75)","Hfp(97)","Jfq(26)","Dnsay(72)","Hljt(51)","Ibink(32)","Obcbxb(124)","Alrksy(69)","Qbmk(45)","Qiy(26)","Uvkdpn(71)","Unsb(26)","Weusps(79)","Fvkhz(104)","Fcclu(70)","Gnplfi(109)","Jvqg(47)","Mtz(72)","Ucqh(51)","Ntfr(70)","Nsgbth(26)","Hcvcgc(97)","Oltadg(95)","Nuq(61)","Kasgmw(95)","Nekuam(17)","Dhe(79)","Okwuq(96)","Qyqifg(85)","Mcnef(59)","Ijveol(46)","Acohsf(86)","Gbkq(77)","Mwwvj(70)","Yeekgc(11)","Ard(82)"};
        for (int i = 0; i < res1.length; i++) {
            System.out.print(res1[i] + ',');
        }
        System.out.println(res.length);
        System.out.println(res1.length);
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        DSU dsu = new DSU(names);
        for (int i = 0; i < synonyms.length; i++) {
            String[] nameArr = synonyms[i].substring(1, synonyms[i].length() - 1).split(",");
            String name1 = nameArr[0];
            String name2 = nameArr[1];
            dsu.union(name1, name2);
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i].substring(0, names[i].indexOf('('));
            String head = dsu.find(name);
            set.add(head + "(" + dsu.frequency.get(head) + ")");
        }

        String[] res = new String[set.size()];
        set.toArray(res);

        return res;
    }

    // 并查集
    class DSU{
        // 初始化一个map，map用于存储每个名字对应的另一个相同意思的字典序最小的名字，初始时为null
        HashMap<String, String> parent;
        // 用于存储每个名字对应的频率
        HashMap<String, Integer> frequency;

        public DSU(String[] names){
            parent = new HashMap<>();
            frequency = new HashMap<>();

            for (int i = 0; i < names.length; i++) {
                String nameWithFreq = names[i];
                int bracketStart = nameWithFreq.indexOf('(');
                int bracketEnd = nameWithFreq.indexOf(')');
                int freq =  Integer.parseInt(nameWithFreq.substring(bracketStart + 1, bracketEnd));
                String name = nameWithFreq.substring(0, bracketStart);
                frequency.put(name, freq);
                parent.put(name, null);
            }
        }

        // 查找某个节点的头节点
        public String find(String name){
            String head = parent.get(name);
            if (head != null)
                return find(head);
            else
                return name;
        }

        // 联通任意两个节点，即让他们的头节点相连
        public void union(String x, String y){
            if (x.compareTo(y) > 0) {
                String yParent = find(y);
                parent.put(x, yParent);
                frequency.put(yParent, frequency.getOrDefault(yParent, 0) + frequency.getOrDefault(x, 0));

            } else if (x.compareTo(y) < 0) {
                String xParent = find(x);
                parent.put(y, xParent);
                frequency.put(xParent, frequency.getOrDefault(xParent, 0) + frequency.getOrDefault(y, 0));
            }
        }
    }
}
