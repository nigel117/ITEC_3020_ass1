document.addEventListener('DOMContentLoaded', function() {
    const blogList = document.getElementById('blog-list');

    fetch('./posts.json')
        .then(response => response.json())
        .then(posts => {
            posts.forEach(post => {
                const postElement = document.createElement('div');
                postElement.classList.add('post'); 
                const titleElement = document.createElement('h2');
                titleElement.textContent = post.title;
                postElement.appendChild(titleElement);

                const nameElement = document.createElement('h3');
                nameElement.textContent = post.name;
                postElement.appendChild(nameElement);

                const dateElement = document.createElement('p');
                dateElement.classList.add('date'); 
                dateElement.textContent = post.date;
                postElement.appendChild(dateElement);
                 const contentElement = document.createElement('p');
                contentElement.classList.add('content'); 
                contentElement.textContent = post.content;
                postElement.appendChild(contentElement);

                blogList.appendChild(postElement);
            });
        })
        .catch(error => console.error('Error loading blog posts:', error));
});
