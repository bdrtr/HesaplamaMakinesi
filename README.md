
# calculator-with-AST

Bu proje AST kullanılarak oluşturulmuş bir hesap makinesidir.

## Ekran Görüntüleri

![örnek 1](https://user-images.githubusercontent.com/69633060/228752557-eaf73c6f-1436-413f-97d3-b49ccc3b0712.jpeg)

![örnek 2](https://user-images.githubusercontent.com/69633060/228752395-69aa55b1-82b0-47db-b64c-8b41d2def821.png)

  

## Kullanım/Örnekler

Kod, her girdiyi bir "token" olarak adlandırılan birimlere ayırır ve bu tokenleri işlem önceliklerine göre düzenler. Ayrıca tam sayıları ve ondalıklı sayıları birbirinden ayırt edebilir.

Ancak, "+1" veya "2(3*2)" gibi kullanımlardan kaçınılması gerekir. Bu kullanımlar, tokene dönüşecek ifadeler içermediği için hata verecektir.

Sayı hassasiyeti, "double" veri tipi ile artırılmıştır. Bilgisayar sistemlerinde hesaplama yaparken, sayıların baz noktalarından sonra belirli bir hassasiyeti olmaması gerektiği konusunda bazı değişiklikler içerebilir.

![örnek 3](https://user-images.githubusercontent.com/69633060/229347694-afe84d74-4a0e-4956-8a92-da80a0b1c580.png)

Bilgisayarlar, sayıları bilgisayar belleğinde tutmak için sınırlı miktarda bit kullanırlar. Bu nedenle, çok küçük sayılar gibi hassas sayılar için tam olarak doğru bir gösterim elde etmek zordur.

0.000003 ve 0.000002 gibi çok küçük sayılar, bilgisayar belleğinde sadece sınırlı sayıda bitle temsil edilebilirler. Bu, bu sayıların tam olarak doğru bir şekilde gösterilemeyeceği anlamına gelir.

Örneğin, bir 32-bit işletim sistemi kullanıyorsanız, bellek bölgesinde sadece 32-bitlik sayılar kullanabilirsiniz. Bu da en küçük değerin 2^-32 olduğu anlamına gelir. Bu, 0.000003 veya 0.000002 gibi çok küçük sayılar için yeterli olmayabilir.

Bilgisayarlar, bu gibi hassas sayıları temsil etmek için kayan nokta aritmetiği kullanırlar. Ancak, kayan nokta aritmetiği de tam olarak doğru sonuçlar veremez. Bu nedenle, 0.000003 ve 0.000002 gibi sayılar için tam olarak doğru sonuçlar elde etmek zordur ve genellikle yaklaşık sonuçlar verilir.
