namespace ProjetoBanco05.Models
{
    public class Conta
    {
        public long Id { get; set; }
        public string? Cpf  { get; set; }
        public string? Email { get; set; }
        public string? Nome {get; set;}
        public string? Telefone {get; set;}
        public double Saldo {get; set;}
        public string? Agencia {get; set;}
        public int TipoConta{get; set;}
        public long Titular{ get; set;}
    }
}