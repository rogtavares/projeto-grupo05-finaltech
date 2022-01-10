using Microsoft.EntityFrameworkCore;

namespace ProjetoBanco05.Models
{
    public class ContaContext : DbContext
    {
    public ContaContext(DbContextOptions<ContaContext> options) : base(options)
    {
    }
    public DbSet<Conta> Contas { get; set; } = null!;
    }
}