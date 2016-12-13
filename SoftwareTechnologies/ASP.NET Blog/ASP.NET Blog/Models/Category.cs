using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ASP.NET_Blog.Models
{
    public class Category
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [Index(IsUnique = true)]
        [StringLength(20)]
        public string Name { get; set; }

        public virtual ICollection<Article> Articles { get; set; }

        private ICollection<Article> articles;

        public Category()
        {
            this.articles = new HashSet<Article>();
        }
    }
}