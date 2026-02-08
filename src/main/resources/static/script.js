const apiUrl = '/api/animals';

async function loadAnimals() {
    try {
        const response = await fetch(apiUrl);
        if (!response.ok) throw new Error("Ошибка сети");

        const animals = await response.json();
        const grid = document.getElementById('animal-grid');
        grid.innerHTML = '';

        animals.forEach(animal => {
            const card = document.createElement('div');
            card.className = 'card';

            card.innerHTML = `
                <div class="card-image" style="background-image: url('${animal.imageUrl || 'https://via.placeholder.com/300?text=No+Photo'}')">
                    <div class="species-badge">${animal.species}</div>
                </div>
                <div class="card-info">
                    <h3>${animal.name}</h3>
                    <p style="color: #666; font-size: 0.8rem;">Click for more details</p>
                    <div class="card-actions" style="margin-top: 15px; display: flex; gap: 5px;">
                        <button class="btn-edit" style="flex:1">Edit</button>
                        <button class="btn-delete" style="flex:1; background:#ff4444; color:white; border:none; border-radius:4px; cursor:pointer;">Delete</button>
                    </div>
                </div>
            `;

            card.onclick = (e) => {
                if (!e.target.closest('button')) {
                    openModal(animal);
                }
            };

            card.querySelector('.btn-edit').onclick = (e) => {
                e.stopPropagation();
                editAnimal(animal);
            };

            card.querySelector('.btn-delete').onclick = (e) => {
                e.stopPropagation();
                deleteAnimal(animal.id);
            };

            grid.appendChild(card);
        });
    } catch (error) {
        console.error("Ошибка при загрузке:", error);
    }
}

function openModal(animal) {
    const modal = document.getElementById('animalModal');
    const modalImg = document.getElementById('modalImg');

    modalImg.src = animal.imageUrl || 'https://via.placeholder.com/300?text=No+Photo';
    modalImg.style.objectFit = "cover";

    const modalText = document.querySelector('.modal-text');
    modalText.innerHTML = `
        <div class="species-tag">${animal.species}</div>
        <h2 style="color: #2d5a27; margin: 10px 0;">${animal.name}</h2>
        
        <p style="margin: 5px 0;"><strong>Age:</strong> ${animal.age} years old</p>
        
        <div class="diet-box" style="background: #e8f5e9; padding: 15px; border-radius: 10px; margin: 15px 0; border-left: 5px solid #2d5a27;">
            <strong>🍎 Diet Plan:</strong><br>
            ${animal.diet || "No specific diet assigned yet."}
        </div>
        
        <div style="margin-top: 15px;">
            <strong>Description:</strong>
            <p style="color: #444; line-height: 1.5; margin-top: 5px; font-style: italic;">
                "${animal.description || "No bio available for this animal."}"
            </p>
        </div>
        
        <button onclick="closeModal()" class="btn-save" style="margin-top: auto; width: 100%; background: #2d5a27; color: white; padding: 12px; border: none; border-radius: 8px; cursor: pointer;">Close Details</button>
    `;

    modal.style.display = 'block';
}

document.getElementById('animal-form').addEventListener('submit', async (e) => {
    e.preventDefault();

    const id = document.getElementById('animal-id').value;
    const animalData = {
        name: document.getElementById('name').value,
        species: document.getElementById('species').value, // теперь текст
        age: parseInt(document.getElementById('age').value),
        description: document.getElementById('description').value,
        imageUrl: document.getElementById('imageUrl').value,
        diet: document.getElementById('diet').value // собираем диету из формы
    };

    const method = id ? 'PUT' : 'POST';
    const url = id ? `${apiUrl}/${id}` : apiUrl;

    try {
        const response = await fetch(url, {
            method: method,
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(animalData)
        });

        if (response.ok) {
            resetForm();
            loadAnimals();
        }
    } catch (error) {
        console.error("Ошибка при сохранении:", error);
    }
});

async function deleteAnimal(id) {
    if (confirm('Are you sure you want to delete this animal?')) {
        try {
            const response = await fetch(`${apiUrl}/${id}`, { method: 'DELETE' });
            if (response.ok) loadAnimals();
        } catch (error) {
            console.error("Ошибка при удалении:", error);
        }
    }
}

function editAnimal(animal) {
    document.getElementById('animal-id').value = animal.id;
    document.getElementById('name').value = animal.name;
    document.getElementById('species').value = animal.species;
    document.getElementById('age').value = animal.age;
    document.getElementById('description').value = animal.description;
    document.getElementById('imageUrl').value = animal.imageUrl;
    document.getElementById('diet').value = animal.diet || ''; // передаем диету в форму

    window.scrollTo({ top: 0, behavior: 'smooth' });
}

function resetForm() {
    document.getElementById('animal-form').reset();
    document.getElementById('animal-id').value = '';
}

function closeModal() {
    document.getElementById('animalModal').style.display = 'none';
}

window.onclick = function(event) {
    const modal = document.getElementById('animalModal');
    if (event.target == modal) {
        closeModal();
    }
}

document.addEventListener('DOMContentLoaded', loadAnimals);